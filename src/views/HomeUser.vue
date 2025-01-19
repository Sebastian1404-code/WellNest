<script setup>
import ExplorePlans from "@/components/ExplorePlans.vue"; // Importă componenta ExplorePlans
import AboutViewVue from "./AboutView.vue";
import Testimonials from "../components/Testimonials.vue";

</script>

<template>
    <Navbar />
  <!-- Hero Section -->
  <section class="hero-section">
    <div class="hero-content">
      <h1 class="hero-title">Welcome to Our Fluid Plans</h1>
      <p class="hero-subtitle">
        The site encourages a healthy lifestyle by promoting positive habits, with a focus on friendly competition, local leaderboards, and challenge validation. Users are inspired to improve their physical, mental, and emotional well-being in a fun and interactive way
      </p>
      <!-- Anchor Link for Scrolling -->
      <a href="#blog-section" class="cta-button">Explore Plans</a>
    </div>
  </section>

  <!-- Include ExplorePlans Component -->
  <ExplorePlans />

  <AboutViewVue />
  <Testimonials />
</template>

<style scoped>
/* General Section Styles */
.hero-section,
#blog-section {
  width: 100%;
  padding: 4rem 2rem;
  color: white;
  text-align: center;
}

/* Hero Section */
.hero-section {
  position: relative;
  height: 70vh;
  /*background-color: black; /* Set background to black */
  background-image: url('@/components/pngs/herobg.png'); /* Replace 'your-image-name.png' with your file name */
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white;
}

.hero-content {
  text-align: center;
  background-color: rgba(0, 0, 0, 0.6); /* Transparent dark background */
  padding: 2rem;
  border-radius: 12px;
}

.hero-title {
  font-size: 2.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
  color: white;
}

.hero-subtitle {
  font-size: 1.2rem;
  line-height: 1.5;
  margin-bottom: 1.5rem;
  color: #ddd;
}

.cta-button {
  display: inline-block;
  padding: 1rem 2rem;
  font-size: 1rem;
  color: #000;
  background-color: #00ffaf;
  border-radius: 8px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s;
}

.cta-button:hover {
  background-color: #00d68f;
}

/* Blog Section */
.section-heading {
  font-size: 2rem;
  margin-bottom: 2rem;
  color: white;
}

.plans-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 1.5rem;
}

.plan-card {
  position: relative;
  background: linear-gradient(145deg, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0));
  padding: 2rem;
  border-radius: 12px;
  text-align: left;
  transition: transform 0.3s, box-shadow 0.3s;
}

.plan-card.highlight {
  border: 2px solid #00ffaf;
  background: linear-gradient(145deg, rgba(0, 255, 175, 0.1), rgba(0, 255, 175, 0));
}

.plan-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.5);
}

.badge {
  position: absolute;
  top: 1rem;
  left: 1rem;
  background-color: #00ffaf;
  color: #000;
  padding: 0.4rem 1rem;
  border-radius: 20px;
  font-size: 0.8rem;
  font-weight: bold;
}

.plan-title {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
  color: white;
}

.plan-subtitle {
  font-size: 1rem;
  line-height: 1.5;
  margin-bottom: 1.5rem;
  color: #ccc;
}

.plan-price {
  font-size: 1.2rem;
  font-weight: bold;
  color: white;
  margin-bottom: 1.5rem;
}

.plan-button {
  display: inline-block;
  text-align: center;
  padding: 0.8rem 1.5rem;
  font-size: 1rem;
  color: #000;
  background-color: #00ffaf;
  border-radius: 8px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s;
}

.plan-button:hover {
  background-color: #00d68f;
}
</style>
