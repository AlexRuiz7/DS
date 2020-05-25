<template>
  <v-container
  >
  <h1 class="text-center">Valoralo todo</h1>
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="12"
        sm="8"
        md="4"
      >
      <!--Formulario de registro-->
        <v-card class="elevation-12">
          <v-toolbar
            color="secondary"
            dark
            flat
          >
            <v-toolbar-title>Registrarse</v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                id="registro_nombre"
                label="Nombre"
                name="registro_nombre"
                type="text"
              ></v-text-field>
              <v-text-field
                id="registro_email"
                label="Correo"
                name="registro_email"
                type="text"
              ></v-text-field>
              <v-text-field
                id="registro_pass"
                label="Contraseña"
                name="registro_pass"
                type="password"
              ></v-text-field>
              <v-text-field
                id="registro_re_pass"
                label="Confirmar contraseña"
                name="registro_re_pass"
                type="password"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="secondary">Registrarme</v-btn>
          </v-card-actions>
        </v-card>
        <!--Formulario de login-->
        <v-card class="elevation-12">
          <v-toolbar
            color="primary"
            dark
            flat
          >
            <v-toolbar-title>Iniciar sesion</v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                id="login_nombre"
                label="Nombre"
                name="nombre"
                type="text"
              ></v-text-field>

              <v-text-field
                id="login_pass"
                label="Contraseña"
                name="pass"
                type="password"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary">Entrar</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    props: {
      source: String,
    },
  }
</script>
