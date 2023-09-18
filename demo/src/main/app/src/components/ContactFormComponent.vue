<template>
  <div
    class="modal fade"
    :id="props.target"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">{{ props.title }}</h5>

          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>

        <div class="modal-body">
          <form>
            <div class="row">
              <div class="mx-auto col-10 col-md-8 col-lg-6">
                <div class="mb-3">
                  <label for="email" class="form-label">Email <span>*</span></label>
                  <input
                    v-model="email"
                    type="text"
                    class="form-control"
                    id="email"
                    aria-describedby="emailHelp"
                  />
                </div>
                <div class="mb-3">
                  <label for="message" class="form-label">message <span>*</span></label>
                  <textarea
                    v-model="message"
                    type="text"
                    class="form-control"
                    id="message"
                    aria-describedby="emailHelp"
                  ></textarea>
                </div>
              </div>
            </div>
          </form>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

          <button type="button" class="btn btn-primary" :onclick="handleSubmit">Submit</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { postRequest } from '../services/CoachRequestService'
const email = ref('')
const message = ref('')
const props = defineProps({
  title: {
    type: String
  },

  body: {
    type: String
  },

  target: {
    type: String
  },
  coachId: {
    type: Number,
    required: true
  }
})
const handleSubmit = async () => {
  await postRequest(email.value, message.value, props.coachId)
}
</script>
