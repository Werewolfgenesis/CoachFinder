<template>
  <nav class="navbar navbar-expand-sm navbar-dark bg-secondary m-0" data-bs-theme="dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">COACHFINDER</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mb-1 mb-lg-0">
          <li class="nav-item">
            <router-link class="nav-link" aria-current="page" to="/">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/all-coaches">All Coaches</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/all-requests">Requests</router-link>
          </li>
          <div v-if="user" class="d-flex">
            <li class="nav-item ">
              <router-link class="nav-link" to="/register">Register</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/login">Login</router-link>
            </li>
          </div>
          <li v-else class="nav-item">
            <router-link class="nav-link" to="/logout">Logout</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script setup lang="ts">
import { ref } from 'vue'

const user = ref<boolean>(true)
</script>
