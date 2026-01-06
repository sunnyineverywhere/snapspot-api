import { StarIcon } from "lucide-react"

export function Rating({
  value,
  count,
}: {
  value: number
  count?: number
}) {
  return (
    <div className="flex items-center gap-1 text-sm text-muted-foreground">
      <StarIcon className="size-4 fill-primary text-primary" />
      <span className="font-medium text-foreground">{value.toFixed(1)}</span>
      {typeof count === "number" ? <span>({count})</span> : null}
    </div>
  )
}


