<template>
  <section class="blog-section">
    <h2 class="section-heading">Habits & Productivity Insights</h2>
    <div class="articles-grid">
      <!-- Article 1 (Index 0) -->
      <div class="article-card article-card-0">
        <h3 class="article-title">Overcoming Procrastination</h3>
        <p class="article-subtitle">Learn simple strategies...</p>
        <a href="#" class="article-button">Read More</a>
      </div>

      <!-- Article 2 (Index 1, highlighted) -->
      <div class="article-card article-card-1 highlight">
        <div class="badge">TOP TRENDING</div>
        <h3 class="article-title">Consistency is Key</h3>
        <p class="article-subtitle">Habits stick when we show up daily...</p>
        <a href="#" class="article-button">Read More</a>
      </div>

      <!-- Article 3 (Index 2) -->
      <div class="article-card article-card-2">
        <h3 class="article-title">The Power of Journaling</h3>
        <p class="article-subtitle">Develop self-awareness...</p>
        <a href="#" class="article-button">Read More</a>
      </div>

      <!-- Article 4 (Index 3) -->
      <div class="article-card article-card-3">
        <h3 class="article-title">The Art of Single-Tasking</h3>
        <p class="article-subtitle">Boost productivity by focusing...</p>
        <a href="#" class="article-button">Read More</a>
      </div>

      <!-- Article 5 (Index 4) -->
      <div class="article-card article-card-4">
        <h3 class="article-title">Habit Formation Science</h3>
        <p class="article-subtitle">Understand the psychology behind habit loops...</p>
        <a href="#" class="article-button">Read More</a>
      </div>

      <!-- Article 6 (Index 5) -->
      <div class="article-card article-card-5">
        <h3 class="article-title">Digital Detox for Better Focus</h3>
        <p class="article-subtitle">Learn to set boundaries with technology...</p>
        <a href="#" class="article-button">Read More</a>
      </div>

      <!-- Article 7 (Index 6) -->
      <div class="article-card article-card-6">
        <h3 class="article-title">Reflecting on Daily Wins</h3>
        <p class="article-subtitle">Build confidence and motivation...</p>
        <a href="#" class="article-button">Read More</a>
      </div>
    </div>
  </section>
</template>

<style scoped>
/* Blog Section */
.blog-section {
  padding: 4rem 2rem;
  background: linear-gradient(90deg, #afe2ab, #538838);
  color: white;
  text-align: center;
  animation: fadeInSection 1.5s ease-in-out;
}

@keyframes fadeInSection {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.section-heading {
  font-size: 2.5rem;
  margin-bottom: 3rem;
  color: #ffffff;
  animation: slideInDown 1s ease-out;
}

@keyframes slideInDown {
  from {
    opacity: 0;
    transform: translateY(-50px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* Grid for Articles */
.articles-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
}

/* Article Card */
/* Ensure the highlight card is visible */
.article-card.highlight {
  border: 2px solid #00ffaf;
  background: linear-gradient(145deg, rgba(0, 255, 175, 0.2), rgba(0, 255, 175, 0.1));
  animation: pulseHighlight 2s infinite, fadeInCard 1s ease-out forwards; /* Combined animations */
  z-index: 1; /* Ensure it's above other cards */
  opacity: 1 !important; /* Ensure the opacity is applied correctly */
  transform: translateY(0) !important; /* Ensure the transform is properly applied */
}

.article-card {
  position: relative;
  background: linear-gradient(145deg, rgba(255, 255, 255, 0.1), rgba(0, 0, 0, 0.2));
  padding: 2rem;
  border-radius: 12px;
  text-align: left;
  transition: transform 0.4s, box-shadow 0.4s;
  opacity: 0; /* Initial opacity */
  transform: translateY(20px); /* Initial position */
  animation: fadeInCard 1s ease-out forwards; /* Make sure forwards is applied */
  animation-fill-mode: forwards; /* Ensure final frame persists */
}

@keyframes fadeInCard {
  0% {
    opacity: 0;
    transform: translateY(20px);
  }
  100% {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes pulseHighlight {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.05);
  }
  100% {
    transform: scale(1);
  }
}



/* Hover Effect */
.article-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.5), 0 0 15px #538838;
}

/* Badge */
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
  animation: bounceIn 1.5s ease-out;
}

@keyframes bounceIn {
  0% {
    transform: scale(0.8);
    opacity: 0;
  }
  50% {
    transform: scale(1.1);
    opacity: 1;
  }
  100% {
    transform: scale(1);
  }
}

/* Article Title */
.article-title {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
  color: white;
}

/* Article Subtitle */
.article-subtitle {
  font-size: 1rem;
  line-height: 1.5;
  margin-bottom: 1.5rem;
  color: #ccc;
}

/* Button */
.article-button {
  display: inline-block;
  text-align: center;
  padding: 0.8rem 1.5rem;
  font-size: 1rem;
  color: #000;
  background-color: #00ffaf;
  border-radius: 8px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s, transform 0.3s;
}

.article-button:hover {
  background-color: #00d68f;
  transform: scale(1.1);
  box-shadow: 0 0 10px #00ffaf;
}


</style>
