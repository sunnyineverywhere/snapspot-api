import Link from "next/link"

import { InstagramIcon, YoutubeIcon } from "lucide-react"

type SocialLink = {
  label: string
  href: string
  icon: React.ReactNode
}

const SOCIALS: SocialLink[] = [
  {
    label: "Instagram",
    href: "/",
    icon: <InstagramIcon className="size-4" />,
  },
  {
    label: "YouTube",
    href: "/",
    icon: <YoutubeIcon className="size-4" />,
  },
]

export function SocialLinks() {
  return (
    <div className="flex items-center gap-2">
      {SOCIALS.map((item) => (
        <Link
          key={item.label}
          href={item.href}
          className="inline-flex items-center justify-center rounded-lg border border-border bg-background/50 p-2 text-muted-foreground transition-colors hover:text-foreground"
          aria-label={item.label}
        >
          {item.icon}
        </Link>
      ))}
    </div>
  )
}


