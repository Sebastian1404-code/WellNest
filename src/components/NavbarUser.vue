<template>
    <CNavbar expand="lg" class="custom-navbar">
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
          <CNavbarNav class="ms-auto"> <!-- Align items to the right -->
            <!-- My Account Dropdown -->
            <CDropdown variant="nav-item" class="custom-dropdown">
              <CDropdownToggle class="custom-link">My Account</CDropdownToggle>
              <CDropdownMenu>
                <CDropdownItem href="/my-leaderboards">My Leaderboards</CDropdownItem>
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
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
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
  } from '@coreui/vue';
  
  const visible = ref(false);
  const router = useRouter();
  
  // Logout function
  function handleLogout() {
    // Clear localStorage or other session storage mechanisms
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('nickname');
  
    // Redirect to the login page
    router.push('/login');
  }
  </script>
  
  <style scoped>
  /* Custom Navbar Styling */
  .custom-navbar {
    background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
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
  