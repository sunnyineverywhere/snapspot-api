export function HeroCopy() {
  return (
    <div className="space-y-4">
      <p className="inline-flex items-center rounded-full border bg-background/60 px-3 py-1 text-xs font-medium text-foreground/80 backdrop-blur">
        사진작가 예약을 더 쉽고 빠르게
      </p>
      <h1 className="text-3xl font-bold leading-tight tracking-tight sm:text-4xl lg:text-5xl">
        완벽한 순간을 담아줄 작가를
        <br className="hidden sm:block" />
        <span className="text-primary"> 지금 만나보세요</span>
      </h1>
      <p className="max-w-xl text-base text-muted-foreground sm:text-lg">
        지역, 촬영 유형, 예산에 맞는 작가를 비교하고 원하는 일정으로 간편하게
        예약하세요.
      </p>
    </div>
  )
}


