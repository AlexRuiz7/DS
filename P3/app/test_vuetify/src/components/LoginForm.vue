<template>

<v-col>
      <v-card class="elevation-12">
        
        <v-toolbar color="secondary" dark flat>
          <v-toolbar-title>Iniciar sesión</v-toolbar-title>
        </v-toolbar>
        
        <v-card-text>
            <v-text-field label="Correo electrónico" v-model="email" type="text"/>

            <v-text-field label="Contraseña" v-model="password" type="password"/>
        </v-card-text>
        
        <v-card-actions>
          <v-btn color="secondary" block @click="login()">Enviar</v-btn>
        </v-card-actions>

      </v-card>
    </v-col>
    
</template>

<script>
export default {
    name: "FormularioInicio",

    data: () => ({
        email: '',
        password: ''
    }),
    
    methods: {
        login() {
            var usuario = {
                email: this.email,
                password: this.password
            };
            this.$store.dispatch('login', usuario);
        }
    }
}
</script>