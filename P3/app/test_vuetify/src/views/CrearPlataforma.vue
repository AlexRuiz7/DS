<template>
  <div>
    <h1 v-text="encabezado"></h1>
    <h1>NUEVA Plataforma</h1>
    <CreaPlataformaForm/>
  </div>
</template>

<script>
import CreaPlataformaForm from '@/components/CreaPlataformaForm.vue'

export default {
    components: {
        CreaPlataformaForm
    }
}
</script>