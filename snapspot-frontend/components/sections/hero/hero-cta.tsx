import Link from "next/link"

import { Button } from "@/components/ui/button"

export function HeroCta() {
  return (
    <div className="flex flex-col gap-2 sm:flex-row">
      <Button asChild size="lg" className="h-10 px-5">
        <Link href="/photographers">작가 찾아보기</Link>
      </Button>
      <Button
        asChild
        size="lg"
        variant="outline"
        className="h-10 px-5 bg-background/60"
      >
        <Link href="/partners/apply">작가 등록하기</Link>
      </Button>
    </div>
  )
}


