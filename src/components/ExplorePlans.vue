<template>
    <section id="blog-section">
      <h2 class="section-heading">Our Fluid Plans</h2>
      <div class="plans-grid">
        <!-- Loop through the plans and display them -->
        <div
          v-for="(plan, index) in plans"
          :key="index"
          class="plan-card"
          :class="{ highlight: plan.highlight }"
        >
          <!-- Highlight Badge -->
          <div v-if="plan.highlight" class="badge">
            {{ plan.highlight === true ? 'MOST POPULAR' : plan.highlight }}
          </div>
  
          <!-- Title -->
          <h3 class="plan-title">{{ plan.title }}</h3>
  
          <!-- Subtitle -->
          <p class="plan-subtitle">{{ plan.subtitle }}</p>
  
          <!-- Price -->
          <p v-if="plan.price" class="plan-price">{{ plan.price }}</p>
  
          <!-- Button -->
          <a href="#" class="plan-button">{{ plan.buttonText }}</a>
        </div>
      </div>
    </section>
  </template>
  
  <script setup>
  import { ref } from "vue";
  
  // Define the plans with Free Trial, Premium Plan, and Basic Plan
  const plans = ref([
    {
      title: "Free Trial",
      subtitle: "Experience our services with limited features for free.",
      price: "Free",
      buttonText: "Start Free Trial",
      highlight: false,
    },
    {
      title: "Premium Plan",
      subtitle: "Unlock all features and enjoy premium support.",
      price: "$49/month",
      buttonText: "Choose Premium",
      highlight: true, // Highlights as "MOST POPULAR"
    },
    {
      title: "Basic Plan",
      subtitle: "Get started with the essential features.",
      price: "$19/month",
      buttonText: "Choose Basic",
      highlight: false,
    },
  ]);
  </script>
  
  <style scoped>
/* Blog Section */
.section-heading {
  font-size: 2rem;
  margin-bottom: 2rem;
  color: white;
}

#blog-section {
  background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
  padding: 4rem 2rem;
  color: white;
  text-align: center;
  border-radius: 12px; /* Optional: round corners */
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2); /* Optional: shadow effect */
}

.plans-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 1.5rem;
}

.plan-card {
  position: relative;
  background: white; /* Use a solid white background for contrast */
  padding: 2rem;
  border-radius: 12px;
  text-align: left;
  transition: transform 0.3s, box-shadow 0.3s;
}

.plan-card.highlight {
  border: 2px solid #094925;
  background: linear-gradient(90deg, #cfe8c2, #8db889); /* Slightly lighter gradient for highlight */
}

.plan-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.3);
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
  color: #333;
}

.plan-subtitle {
  font-size: 1rem;
  line-height: 1.5;
  margin-bottom: 1.5rem;
  color: #666;
}

.plan-price {
  font-size: 1.2rem;
  font-weight: bold;
  color: #444;
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