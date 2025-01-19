

<template>
    <div class="testimonials-page">
      <section class="testimonials-section">
        <h1 class="section-title">What Our Customers Say</h1>
        <p class="section-subtitle">
          Discover how we've helped our customers achieve their goals.
        </p>
  
        <!-- Testimonials Container -->
        <div class="testimonials-container">
          <div class="testimonial-card" v-for="(testimonial, index) in testimonials" :key="index">
            <div class="profile-image-container">
              <img :src="testimonial.image" :alt="testimonial.name" class="profile-image" />
            </div>
            <p class="testimonial-text">{{ testimonial.text }}</p>
            <h3 class="testimonial-name">{{ testimonial.name }}</h3>
            <p class="testimonial-role">{{ testimonial.role }}</p>
          </div>
        </div>
  
        <!-- Navigation Buttons -->
        <div class="navigation-buttons">
          <button class="nav-button" @click="prevSlide">❮</button>
          <button class="nav-button" @click="nextSlide">❯</button>
        </div>
      </section>
    </div>
  </template>
  <script setup>
  import { ref } from "vue";
  import man1 from "./pngs/man1.jpg";
  import man2 from "./pngs/man2.jpg";
  import man3 from "./pngs/man3.jpg";
  
  // Testimonials Data
  const testimonials = ref([
    {
      name: "Mike Torello",
      role: "Executive Engineer",
      text: "This platform has truly transformed how we work. It's fast, reliable, and has helped us streamline our processes.",
      image: man1,
    },
    {
      name: "Rick Wright",
      role: "Senior Designer",
      text: "I've never experienced such a seamless workflow. The team's support is outstanding, and the results speak for themselves.",
      image: man2,
    },
    {
      name: "Devon Miles",
      role: "Project Manager",
      text: "Using this service has been a game-changer for our team. We’ve achieved more in the past year than we ever thought possible.",
      image: man3,
    },
  ]);
  
  const currentIndex = ref(0);
  
  function nextSlide() {
    currentIndex.value = (currentIndex.value + 1) % testimonials.value.length;
  }
  
  function prevSlide() {
    currentIndex.value =
      (currentIndex.value - 1 + testimonials.value.length) % testimonials.value.length;
  }
  </script>
  <style scoped>
  /* Testimonials Section */
  .testimonials-page {
    background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
    padding: 60px 20px;
    text-align: center;
  }
  
  .testimonials-section {
    max-width: 1200px;
    margin: 0 auto;
    border-radius: 20px;
    background-color: white;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
    padding: 40px;
    overflow: hidden;
    position: relative;
  }
  
  .section-title {
    font-size: 2.5rem;
    font-weight: bold;
    color: #096328;
    margin-bottom: 10px;
  }
  
  .section-subtitle {
    font-size: 1rem;
    color: #555;
    margin-bottom: 30px;
  }
  
  /* Testimonials Container */
  .testimonials-container {
    display: flex;
    justify-content: center;
    gap: 20px;
    flex-wrap: nowrap;
    overflow-x: auto;
    scroll-snap-type: x mandatory;
    padding: 20px 0;
  }
  
  .testimonial-card {
    flex: 0 0 auto;
    width: 300px;
    background-color: #f9f9f9;
    border-radius: 12px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    padding: 20px;
    scroll-snap-align: center;
    text-align: center;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
  }
  
  .testimonial-card:hover {
    transform: translateY(-10px);
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.2);
  }
  
  .profile-image-container {
    position: relative;
    margin-bottom: 15px;
  }
  
  .profile-image {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    object-fit: cover;
    border: 3px solid #44844d;
  }
  
  .testimonial-text {
    font-size: 1rem;
    color: #555;
    margin-bottom: 20px;
  }
  
  .testimonial-name {
    font-size: 1.2rem;
    font-weight: bold;
    color: #357d51;
    margin-bottom: 5px;
  }
  
  .testimonial-role {
    font-size: 0.9rem;
    color: #777;
  }
  
  /* Navigation Buttons */
  .navigation-buttons {
    margin-top: 30px;
    display: flex;
    justify-content: center;
    gap: 10px;
  }
  
  .nav-button {
    background-color: #155317;
    color: white;
    border: none;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    font-size: 1.2rem;
    cursor: pointer;
    transition: transform 0.2s ease, box-shadow 0.2s ease;
  }
  
  .nav-button:hover {
    transform: scale(1.1);
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
  }
  
  @media (max-width: 768px) {
    .testimonial-card {
      width: 90%;
    }
  
    .navigation-buttons {
      margin-top: 20px;
    }
  }
  </style>
  