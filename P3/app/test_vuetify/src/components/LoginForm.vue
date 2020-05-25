<template>

<v-col>
      <v-card class="elevation-12">
        
        <v-toolbar color="secondary" dark flat>
          <v-toolbar-title>Iniciar sesión</v-toolbar-title>
        </v-toolbar>
        
        <v-card-text>
            <v-text-field label="Nombre de usuario" v-model="nombre" type="text"/>

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
        nombre: '',
        password: '',
        usuario: []
    }),
    
    methods: {
        login() {
            this.$http
                .get('http://localhost:8081/api/usuarios/' + this.nombre)
                .then(response => this.usuario = response.data[0])
                .catch(error => {
                    if (error.response.status == 404)
                        alert("Usuario no encontrado")
                })

                if (this.usuario != undefined) {
                    console.log(this.usuario.nombre + "," + this.usuario.correo + ", " + this.usuario.contraseña)

                    var user = {
                        email: this.nombre,
                        password: this.password
                    };
                    this.$store.dispatch('login', user);
                }
        }
    }
}
</script>