import { Container } from "@/components/layout/container"
import { HeroCopy } from "@/components/sections/hero/hero-copy"
import { HeroCta } from "@/components/sections/hero/hero-cta"
import { SearchBar } from "@/components/sections/hero/search-bar"

export function HeroSection() {
  return (
    <section className="relative overflow-hidden">
      <div className="pointer-events-none absolute inset-0 -z-10">
        <div className="absolute -top-24 left-1/2 h-72 w-[800px] -translate-x-1/2 rounded-full bg-primary/20 blur-3xl" />
        <div className="absolute bottom-0 right-0 h-72 w-72 rounded-full bg-primary/10 blur-3xl" />
      </div>
      <Container className="py-14 sm:py-16">
        <div className="grid gap-10 lg:grid-cols-[1.1fr_0.9fr] lg:items-center">
          <div>
            <HeroCopy />
            <div className="mt-6">
              <HeroCta />
            </div>
            <SearchBar />
          </div>

          <div className="relative hidden lg:block">
            <div className="absolute inset-0 rounded-3xl bg-gradient-to-br from-primary/15 via-transparent to-primary/10" />
            <div className="relative aspect-[4/5] overflow-hidden rounded-3xl border bg-muted/30">
              <div className="absolute inset-0 bg-[radial-gradient(circle_at_top,rgba(0,0,0,0.06),transparent_55%)]" />
              <div className="absolute inset-x-6 bottom-6 rounded-2xl border bg-background/80 p-4 backdrop-blur">
                <p className="text-sm font-medium">추천 작가</p>
                <p className="mt-1 text-sm text-muted-foreground">
                  평점 4.9 · 스냅/프로필 전문
                </p>
              </div>
            </div>
          </div>
        </div>
      </Container>
    </section>
  )
}


