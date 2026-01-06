import { Header } from "@/components/layout/header"
import { Footer } from "@/components/layout/footer"
import { HeroSection } from "@/components/sections/hero/hero-section"
import { FeaturesSection } from "@/components/sections/features/features-section"
import { PhotographersSection } from "@/components/sections/photographers/photographers-section"
import { TestimonialsSection } from "@/components/sections/testimonials/testimonials-section"
import { CtaSection } from "@/components/sections/cta/cta-section"

export function HomePage() {
  return (
    <div className="min-h-dvh">
      <Header />
      <main>
        <HeroSection />
        <FeaturesSection />
        <PhotographersSection />
        <TestimonialsSection />
        <CtaSection />
      </main>
      <Footer />
    </div>
  )
}


