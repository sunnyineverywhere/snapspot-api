import Link from "next/link"

import { Container } from "@/components/layout/container"
import { Button } from "@/components/ui/button"
import { CheckCircle2Icon } from "lucide-react"

const BULLETS = [
  "작가 비교부터 예약까지 한 번에",
  "리뷰와 포트폴리오로 신뢰도 확인",
  "안전한 결제와 명확한 정책",
]

export function CtaSection() {
  return (
    <section className="py-14 sm:py-16">
      <Container>
        <div className="relative overflow-hidden rounded-3xl border bg-gradient-to-br from-primary/15 via-background to-background p-8 sm:p-10">
          <div className="pointer-events-none absolute -right-24 -top-24 size-72 rounded-full bg-primary/20 blur-3xl" />

          <div className="relative grid gap-8 lg:grid-cols-[1.3fr_0.7fr] lg:items-center">
            <div className="space-y-4">
              <h2 className="text-2xl font-bold tracking-tight sm:text-3xl">
                오늘, SnapSpot에서 예약을 시작해보세요
              </h2>
              <p className="max-w-2xl text-muted-foreground">
                원하는 촬영을 더 편하게. 나에게 맞는 작가를 찾고 일정과 옵션을
                선택하면 예약이 끝나요.
              </p>

              <ul className="grid gap-2 text-sm text-foreground/90 sm:grid-cols-2">
                {BULLETS.map((text) => (
                  <li key={text} className="flex items-center gap-2">
                    <CheckCircle2Icon className="size-4 text-primary" />
                    <span>{text}</span>
                  </li>
                ))}
              </ul>
            </div>

            <div className="flex flex-col gap-2">
              <Button asChild size="lg" className="h-10">
                <Link href="/signup">지금 시작하기</Link>
              </Button>
              <Button
                asChild
                size="lg"
                variant="outline"
                className="h-10 bg-background/70"
              >
                <Link href="/photographers">작가 둘러보기</Link>
              </Button>
              <p className="mt-2 text-xs text-muted-foreground">
                가입은 1분이면 충분해요.
              </p>
            </div>
          </div>
        </div>
      </Container>
    </section>
  )
}


