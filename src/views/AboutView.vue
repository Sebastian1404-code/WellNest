<template>
  <div class="about-page">
    <!-- Hero Section -->
    <section class="hero-section">
      <div class="hero-content">
        <h1 class="hero-title animate-fade-in">Your Journey into Creativity</h1>
        <p class="hero-subtitle animate-fade-in-delay">
          Where passion meets professionalism.
        </p>
      </div>
      <div class="line-decorator"></div>
    </section>

    <!-- Our Mission Section -->
    <section class="mission-section">
      <h2 class="section-heading">Our Mission</h2>
      <div class="animated-line"></div>
      <p class="mission-text">
        At Wellnest, we inspire individuals to embrace a healthier lifestyle by fostering positive habits. Through friendly competition, local leaderboards, and engaging challenges, we aim to create an interactive and enjoyable platform that promotes physical, mental, and emotional well-being. Together, let's build a healthier, happier community! 
      </p>
    </section>

   

    <!-- Footer Section -->
    <section class="footer-section">
      <h2 class="section-heading">Our Clients</h2>
      <div class="animated-line"></div>
      <div class="clients-logos">
        <img src="https://via.placeholder.com/150" alt="Client Logo" />
        <img src="https://via.placeholder.com/150" alt="Client Logo" />
        <img src="https://via.placeholder.com/150" alt="Client Logo" />
      </div>
    </section>
  </div>
</template>


<style scoped>
/* General Styling */
.about-page {
  font-family: 'Arial', sans-serif;
  color: #333;
  overflow: hidden;
}

/* Hero Section */
.hero-section {
  position: relative;
  background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
  color: white;
  text-align: center;
  padding: 80px 20px;
  overflow: hidden;
}

.hero-title {
  font-size: 3rem;
  font-weight: bold;
  margin-bottom: 10px;
  animation: slide-in 1s ease-out;
}

.hero-subtitle {
  font-size: 1.5rem;
  font-weight: 300;
  animation: slide-in 1.5s ease-out;
}

.line-decorator {
  width: 80%;
  height: 2px;
  background: white;
  margin: 20px auto 0 auto;
  animation: fade-in 1.5s ease-in-out;
}

/* Mission Section */
.mission-section {
  position: relative;
  background-color: #f9f9f9;
  text-align: center;
  padding: 60px 20px;
  overflow: hidden;
}

.section-heading {
  font-size: 2.5rem;
  font-weight: bold;
  background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
  margin-bottom: 20px;
  animation: fade-in 1s ease-in-out;
}

.mission-text {
  font-size: 1.2rem;
  color: #555;
  max-width: 800px;
  margin: 0 auto;
}

.animated-line {
  width: 60px;
  height: 4px;
  background: #092b09;
  margin: 10px auto;
  animation: expand-line 0.7s ease-out;
}

/* Team Section */
.team-section {
  position: relative;
  background: white;
  padding: 60px 20px;
  text-align: center;
}

.team-members {
  display: flex;
  justify-content: center;
  gap: 40px;
  flex-wrap: wrap;
}

.team-member {
  max-width: 300px;
  background-color: #f9f9f9;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease-in-out;
}

.team-member:hover {
  transform: translateY(-10px);
  box-shadow: 0 6px 20px rgba(0, 0, 0, 0.2);
}

.team-image {
  border-radius: 50%;
  width: 150px;
  height: 150px;
  object-fit: cover;
  margin-bottom: 20px;
}

.team-name {
  font-size: 1.5rem;
  font-weight: bold;
  color: #34835e;
  margin-bottom: 5px;
}

.team-role {
  font-size: 1.2rem;
  font-weight: bold;
  color: #333;
  margin-bottom: 10px;
}

.team-description {
  font-size: 1rem;
  color: #555;
}

/* Footer Section */
.footer-section {
  position: relative;
  background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
  text-align: center;
  padding: 60px 20px;
}

.clients-logos {
  display: flex;
  justify-content: center;
  gap: 30px;
}

.clients-logos img {
  max-width: 150px;
  height: auto;
  filter: grayscale(100%);
  transition: filter 0.3s ease-in-out;
}

.clients-logos img:hover {
  filter: grayscale(0%);
}

/* Animations */
@keyframes slide-in {
  from {
    transform: translateY(100%);
    opacity: 0;
  }
  to {
    transform: translateY(0);
    opacity: 1;
  }
}

@keyframes fade-in {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes fade-in-delay {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes expand-line {
  from {
    width: 0;
  }
  to {
    width: 60px;
  }
}
</style>
