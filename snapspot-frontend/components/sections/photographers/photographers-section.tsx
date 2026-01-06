import Link from "next/link"

import { Container } from "@/components/layout/container"
import { Button } from "@/components/ui/button"
import {
  PhotographerCard,
  type Photographer,
} from "@/components/sections/photographers/photographer-card"

const POPULAR: Photographer[] = [
  {
    id: "minji-kim",
    name: "김민지",
    specialties: ["스냅", "프로필", "야외"],
    location: "서울 · 성수",
    rating: 4.9,
    reviewCount: 128,
    priceFrom: 120000,
  },
  {
    id: "jason-park",
    name: "박재성",
    specialties: ["웨딩", "커플", "스튜디오"],
    location: "서울 · 강남",
    rating: 4.8,
    reviewCount: 94,
    priceFrom: 180000,
  },
  {
    id: "soyeon-lee",
    name: "이소연",
    specialties: ["가족", "돌잔치", "행사"],
    location: "인천 · 송도",
    rating: 4.9,
    reviewCount: 76,
    priceFrom: 150000,
  },
  {
    id: "daniel-choi",
    name: "최다니엘",
    specialties: ["브랜드", "제품", "룩북"],
    location: "부산 · 해운대",
    rating: 4.7,
    reviewCount: 52,
    priceFrom: 220000,
  },
  {
    id: "hanna-jung",
    name: "정한나",
    specialties: ["프로필", "스튜디오", "보정"],
    location: "대구 · 수성",
    rating: 4.8,
    reviewCount: 63,
    priceFrom: 130000,
  },
  {
    id: "yujin-hong",
    name: "홍유진",
    specialties: ["스냅", "여행", "감성"],
    location: "제주 · 애월",
    rating: 4.9,
    reviewCount: 41,
    priceFrom: 170000,
  },
]

export function PhotographersSection() {
  return (
    <section className="py-14 sm:py-16 bg-muted/10">
      <Container>
        <div className="flex flex-col gap-3 sm:flex-row sm:items-end sm:justify-between">
          <div className="space-y-2">
            <h2 className="text-2xl font-bold tracking-tight sm:text-3xl">
              지금 인기 있는 작가
            </h2>
            <p className="max-w-2xl text-muted-foreground">
              후기와 포트폴리오로 검증된 작가를 빠르게 비교해 보세요.
            </p>
          </div>
          <Button asChild variant="outline" className="sm:self-auto">
            <Link href="/photographers">더 보기</Link>
          </Button>
        </div>

        <div className="mt-8 grid gap-4 sm:grid-cols-2 lg:grid-cols-3">
          {POPULAR.map((p) => (
            <PhotographerCard key={p.id} photographer={p} />
          ))}
        </div>
      </Container>
    </section>
  )
}


