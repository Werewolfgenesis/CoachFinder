<template>
  <div class="mb-4"> 
     <div
    id="navbar"
    class="p-5 text-center bg-image "
    style=" background-position: center; background-image: url('../../public/img/header-photo.jpg');
    "
  >
    <div class="mask headerAnimation" style="background-color: rgba(0, 0, 0, 0.7);">
      <div class="d-flex justify-content-center align-items-center h-100">
        <div class="text-white">
          <h1 class="mb-3 header__text" > COACH FINDER APP</h1>
          <h5 class="mb-4">Find the best coach you need! Improve yourself!</h5>
        </div>
      </div>
    </div>
    
  </div>
  <div class="p-4 introAnimation text-start">
    <h4 class="text-uppercase" style="color: #ff7730;">Introduction</h4>
    <p class="text-secondary" style="max-width: 70%;">Studying at university can be a task in itself, and often students find it hard to focus and concentrate. 
      Studying the wrong way or in the wrong environment can result in lack of interest and minimum work efficiency which is very common in university students. Worried that this might be you? Don’t worry, we have provided you with a list of coaches in every area where you can learn everything you want in the easiest and interesting way!</p>
    </div>
  </div>
   
</template>
<script setup lang="ts">

</script>
<style scoped>





.headerAnimation {
    animation-name: leftToRight;
    animation-duration: 1s;
    animation-timing-function: ease-out;
}
.header__text {
  background-image: linear-gradient(to right, rgb(222, 175, 139), #ef5e10);
  -webkit-background-clip: text;
  color: transparent;
}

.introAnimation {
  animation-name: rightToLeft;
    animation-duration: 1s;
    animation-timing-function: ease-out;
}

</style>