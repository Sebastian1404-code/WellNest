<template>
  <div>
    <!-- Conditionally render the navbar based on login status -->
    <CNavbar v-if="isLoggedIn" expand="lg" class="custom-navbar">
      <CContainer fluid>
        <!-- Navbar Brand -->
        <CNavbarBrand href="/" class="custom-brand">Wellnest</CNavbarBrand>

        <!-- Navbar Toggler -->
        <CNavbarToggler
          aria-label="Toggle navigation"
          aria-expanded="false"
          @click="visible = !visible"
        />

        <!-- Navbar Collapse -->
        <CCollapse class="navbar-collapse" :visible="visible">
          <CNavbarNav class="ms-auto">
            <!-- My Account Dropdown -->
            <CDropdown variant="nav-item" class="custom-dropdown">
              <CDropdownToggle class="custom-link">My Account</CDropdownToggle>
              <CDropdownMenu>
                <CDropdownItem href="/leaderboard">My Leaderboards</CDropdownItem>
                <CDropdownItem href="/calendar">Calendar</CDropdownItem>
                <CDropdownItem href="/my-prizes">My Prizes</CDropdownItem>
                <CDropdownDivider />
                <CDropdownItem href="/account-settings">Account Settings</CDropdownItem>
              </CDropdownMenu>
            </CDropdown>

            <!-- Blog Link -->
            <CNavItem>
              <CNavLink href="/blog" class="custom-link">Blog</CNavLink>
            </CNavItem>

            <!-- Contact Link -->
            <CNavItem>
              <CNavLink href="/contact" class="custom-link">Contact</CNavLink>
            </CNavItem>

            <!-- Log Out -->
            <CNavItem>
              <CNavLink class="custom-link" @click="handleLogout">Log Out</CNavLink>
            </CNavItem>
          </CNavbarNav>
        </CCollapse>
      </CContainer>
    </CNavbar>

    <!-- Default Navbar -->
    <CNavbar v-else expand="lg" class="custom-navbar">
      <CContainer fluid>
        <!-- Navbar Brand -->
        <CNavbarBrand href="/" class="custom-brand">Wellnest</CNavbarBrand>

        <!-- Navbar Toggler -->
        <CNavbarToggler
          aria-label="Toggle navigation"
          aria-expanded="false"
          @click="visible = !visible"
        />

        <!-- Navbar Collapse -->
        <CCollapse class="navbar-collapse" :visible="visible">
          <CNavbarNav class="ms-auto">
            <CNavItem>
              <CNavLink href="/" class="custom-link">Home</CNavLink>
            </CNavItem>
            <CNavItem>
              <CNavLink href="/blog" class="custom-link">Blog</CNavLink>
            </CNavItem>
            <CNavItem>
              <CNavLink href="/contact" class="custom-link">Contact</CNavLink>
            </CNavItem>
            <CNavItem>
              <CNavLink href="/login" class="custom-link">Log In</CNavLink>
            </CNavItem>
          </CNavbarNav>
        </CCollapse>
      </CContainer>
    </CNavbar>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useRouter, useRoute } from "vue-router";
import {
  CNavbar,
  CContainer,
  CNavbarBrand,
  CNavbarToggler,
  CCollapse,
  CNavbarNav,
  CNavItem,
  CNavLink,
  CDropdown,
  CDropdownToggle,
  CDropdownMenu,
  CDropdownItem,
  CDropdownDivider,
} from "@coreui/vue";

// State to track the visibility of the navbar collapse
const visible = ref(false);

// State to track login status
const isLoggedIn = ref(false);

// Router and Route instances
const router = useRouter();
const route = useRoute();

// Fetch login status from localStorage
onMounted(() => {
  isLoggedIn.value = localStorage.getItem("isLoggedIn") === "true";
});

// Watch for route changes to refresh data or reset components
watch(
  () => route.fullPath,
  (newPath, oldPath) => {
    console.log(`Route changed from ${oldPath} to ${newPath}`);
    // Refresh any necessary data here
    handleRouteChange(newPath);
  }
);

// Handle data or state updates on route change
function handleRouteChange(newPath) {
  // For example, refresh the login state
  isLoggedIn.value = localStorage.getItem("isLoggedIn") === "true";

  // Perform additional actions like clearing specific states if needed
  console.log("Route changed, performing auto-refresh");
}

// Logout function
function handleLogout() {
  // Clear login-related data from localStorage
  localStorage.removeItem("isLoggedIn");
  localStorage.removeItem("nickname");

  // Redirect to the login page
  router.push("/login");

  // Update state
  isLoggedIn.value = false;
}
</script>

<style scoped>
/* Custom Navbar Styling */
.custom-navbar {
  background: linear-gradient(90deg, #afe2ab, #538838); /* Gradient background */
  color: white;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  padding: 0.5rem 1rem;
}

.custom-brand {
  font-weight: bold;
  font-size: 1.5rem;
  color: white;
}

.custom-link {
  color: white;
  font-weight: bold;
  margin: 0 1rem;
}

.custom-link:hover {
  color: #fdfdfd;
  text-decoration: underline;
}

.custom-dropdown .dropdown-menu {
  background: white;
  color: black;
  border-radius: 6px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.custom-dropdown .dropdown-menu .dropdown-item:hover {
  background-color: #afe2ab;
  color: black;
}

.ms-auto {
  margin-left: auto; /* Align items to the right */
}
</style>
