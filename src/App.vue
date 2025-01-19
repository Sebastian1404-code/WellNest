<template>
  <div id="app">
    <!-- Global Navbar -->
    <Navbar />

    <!-- Routed Content -->
    <RouterView />
  </div>
</template>

<script setup>
import Navbar from "./components/Navbar.vue"; // Path to the Navbar component
</script>

<style>
/* Optional global styles */
body {
  margin: 0;
  font-family: "Arial", sans-serif;
}
</style>
