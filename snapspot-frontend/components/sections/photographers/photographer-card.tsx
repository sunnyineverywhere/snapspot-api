import Link from "next/link"

import { Badge } from "@/components/ui/badge"
import { Card, CardContent, CardFooter, CardHeader, CardTitle } from "@/components/ui/card"
import { cn } from "@/lib/utils"
import { Rating } from "@/components/sections/photographers/rating"

export type Photographer = {
  id: string
  name: string
  specialties: string[]
  location: string
  rating: number
  reviewCount: number
  priceFrom: number
}

function formatPrice(krw: number) {
  return `${krw.toLocaleString("ko-KR")}원~`
}

export function PhotographerCard({
  photographer,
  className,
}: {
  photographer: Photographer
  className?: string
}) {
  const initials = photographer.name.slice(0, 1)

  return (
    <Card className={cn("overflow-hidden", className)}>
      <CardHeader className="pb-3">
        <div className="flex items-start gap-3">
          <div className="relative inline-flex size-11 shrink-0 items-center justify-center rounded-2xl bg-primary/10 text-lg font-semibold text-primary">
            {initials}
          </div>
          <div className="min-w-0">
            <CardTitle className="truncate">{photographer.name}</CardTitle>
            <p className="mt-0.5 text-sm text-muted-foreground">
              {photographer.location}
            </p>
          </div>
        </div>
      </CardHeader>
      <CardContent className="space-y-3">
        <div className="flex flex-wrap gap-1.5">
          {photographer.specialties.slice(0, 3).map((tag) => (
            <Badge key={tag} variant="secondary">
              {tag}
            </Badge>
          ))}
        </div>
        <Rating value={photographer.rating} count={photographer.reviewCount} />
      </CardContent>
      <CardFooter className="justify-between">
        <p className="text-sm font-semibold">{formatPrice(photographer.priceFrom)}</p>
        <Link
          href={`/photographers/${photographer.id}`}
          className="text-sm font-medium text-primary hover:underline"
        >
          상세 보기
        </Link>
      </CardFooter>
    </Card>
  )
}


