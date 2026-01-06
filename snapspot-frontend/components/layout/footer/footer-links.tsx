import Link from "next/link"

type FooterLink = { label: string; href: string }
type FooterGroup = { title: string; links: FooterLink[] }

const GROUPS: FooterGroup[] = [
  {
    title: "서비스",
    links: [
      { label: "작가 찾기", href: "/photographers" },
      { label: "촬영 유형", href: "/shoot-types" },
      { label: "가격", href: "/pricing" },
    ],
  },
  {
    title: "파트너",
    links: [
      { label: "작가 등록", href: "/partners/apply" },
      { label: "가이드", href: "/partners/guide" },
    ],
  },
  {
    title: "회사",
    links: [
      { label: "소개", href: "/about" },
      { label: "공지사항", href: "/notices" },
      { label: "문의", href: "/contact" },
    ],
  },
]

export function FooterLinks() {
  return (
    <div className="grid grid-cols-2 gap-8 sm:grid-cols-3">
      {GROUPS.map((group) => (
        <div key={group.title} className="space-y-3">
          <p className="text-sm font-semibold">{group.title}</p>
          <ul className="space-y-2 text-sm text-muted-foreground">
            {group.links.map((link) => (
              <li key={link.href}>
                <Link
                  href={link.href}
                  className="transition-colors hover:text-foreground"
                >
                  {link.label}
                </Link>
              </li>
            ))}
          </ul>
        </div>
      ))}
    </div>
  )
}


