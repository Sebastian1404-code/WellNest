<template>
    <section class="contact-section">
      <h2 class="contact-heading">Get in Touch</h2>
      <p class="contact-subtitle">
        We’d love to hear from you! Whether you have questions about building better habits, 
        suggestions for future topics, or want to share your own success story, our door is always open.
      </p>
      <p class="contact-email">
        You can reach us at: <a href="mailto:hello@yourdomain.com">hello@yourdomain.com</a>
      </p>
      
      <form class="contact-form" @submit.prevent="handleSubmit">
        <div class="form-group">
          <label for="name">Name</label>
          <input id="name" v-model="formData.name" type="text" required />
        </div>
        
        <div class="form-group">
          <label for="email">Email</label>
          <input id="email" v-model="formData.email" type="email" required />
        </div>
        
        <div class="form-group">
          <label for="message">Message</label>
          <textarea id="message" v-model="formData.message" rows="5" required></textarea>
        </div>
        
        <button type="submit" class="contact-submit">Send Message</button>
      </form>
    </section>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  
  const formData = ref({ name: '', email: '', message: '' })
  
  const handleSubmit = () => {
    // Here you could send formData to an API or handle it as needed
    alert('Thank you for reaching out! We will get back to you soon.')
    formData.value = { name: '', email: '', message: '' }
  }
  </script>
  
  <style scoped>
  .contact-section {
    padding: 4rem 2rem;
    background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
    color: #333;
    text-align: center;
    animation: fadeInContact 1.5s ease-in-out;
  }
  
  @keyframes fadeInContact {
    from {
      opacity: 0;
      transform: translateY(20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }
  
  .contact-heading {
    font-size: 2.5rem;
    margin-bottom: 2rem;
    color: #333;
  }
  
  .contact-subtitle {
    font-size: 1.1rem;
    line-height: 1.5;
    color: #555;
    margin-bottom: 1.5rem;
    max-width: 600px;
    margin-left: auto;
    margin-right: auto;
  }
  
  .contact-email {
    font-size: 1rem;
    margin-bottom: 2rem;
  }
  
  .contact-email a {
    color: #538838;
    text-decoration: none;
    font-weight: bold;
  }
  
  .contact-form {
    max-width: 600px;
    margin: 0 auto;
    text-align: left;
  }
  
  .form-group {
    margin-bottom: 1.5rem;
  }
  
  .form-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 0.5rem;
  }
  
  .form-group input, 
  .form-group textarea {
    width: 100%;
    padding: 0.8rem;
    border-radius: 6px;
    border: 1px solid #ccc;
    font-size: 1rem;
  }
  
  .contact-submit {
    display: inline-block;
    padding: 0.8rem 1.5rem;
    font-size: 1rem;
    color: #fff;
    background-color: #538838;
    border-radius: 8px;
    text-decoration: none;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.3s;
    border: none;
  }
  
  .contact-submit:hover {
    background-color: #3a5d2a;
    transform: scale(1.05);
  }
  </style>
  