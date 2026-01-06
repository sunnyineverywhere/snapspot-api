import { Container } from "@/components/layout/container"
import { FooterLinks } from "@/components/layout/footer/footer-links"
import { SocialLinks } from "@/components/layout/footer/social-links"

export function Footer() {
  return (
    <footer className="border-t bg-muted/20">
      <Container className="py-12">
        <div className="grid gap-10 lg:grid-cols-[1.2fr_1fr] lg:items-start">
          <div className="space-y-4">
            <p className="text-lg font-semibold tracking-tight">SnapSpot</p>
            <p className="max-w-md text-sm text-muted-foreground">
              검증된 사진작가를 쉽고 빠르게 예약하세요. 촬영 목적과 예산에 맞는
              작가를 비교하고, 안전하게 결제할 수 있어요.
            </p>
            <SocialLinks />
          </div>
          <FooterLinks />
        </div>

        <div className="mt-10 flex flex-col gap-2 border-t pt-6 text-xs text-muted-foreground sm:flex-row sm:items-center sm:justify-between">
          <p>© {new Date().getFullYear()} SnapSpot. All rights reserved.</p>
          <div className="flex gap-4">
            <a className="hover:text-foreground" href="#">
              이용약관
            </a>
            <a className="hover:text-foreground" href="#">
              개인정보처리방침
            </a>
          </div>
        </div>
      </Container>
    </footer>
  )
}


