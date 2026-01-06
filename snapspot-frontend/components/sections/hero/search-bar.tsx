"use client"

import * as React from "react"
import { useRouter } from "next/navigation"

import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import {
  Select,
  SelectContent,
  SelectGroup,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select"
import { SearchIcon } from "lucide-react"

const SHOOT_TYPES = [
  { value: "profile", label: "프로필" },
  { value: "wedding", label: "웨딩" },
  { value: "family", label: "가족" },
  { value: "snap", label: "스냅" },
  { value: "brand", label: "브랜드" },
]

export function SearchBar() {
  const router = useRouter()
  const [location, setLocation] = React.useState("")
  const [shootType, setShootType] = React.useState<string>("")

  function onSubmit(e: React.FormEvent) {
    e.preventDefault()
    const params = new URLSearchParams()
    if (location.trim()) params.set("location", location.trim())
    if (shootType) params.set("type", shootType)
    const query = params.toString()
    router.push(`/photographers${query ? `?${query}` : ""}`)
  }

  return (
    <form
      onSubmit={onSubmit}
      className="mt-8 w-full rounded-2xl border bg-background/80 p-3 shadow-sm backdrop-blur sm:p-4"
    >
      <div className="grid gap-3 sm:grid-cols-[1fr_220px_auto] sm:items-center">
        <div className="relative">
          <Input
            value={location}
            onChange={(e) => setLocation(e.target.value)}
            placeholder="지역을 입력하세요 (예: 서울, 부산)"
            className="h-10"
            aria-label="지역"
          />
        </div>
        <Select value={shootType} onValueChange={setShootType}>
          <SelectTrigger className="h-10">
            <SelectValue placeholder="촬영 유형" />
          </SelectTrigger>
          <SelectContent>
            <SelectGroup>
              {SHOOT_TYPES.map((type) => (
                <SelectItem key={type.value} value={type.value}>
                  {type.label}
                </SelectItem>
              ))}
            </SelectGroup>
          </SelectContent>
        </Select>
        <Button type="submit" className="h-10">
          <SearchIcon data-icon="inline-start" />
          검색
        </Button>
      </div>
    </form>
  )
}


