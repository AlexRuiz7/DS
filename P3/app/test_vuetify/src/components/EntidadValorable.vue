<template>
<v-container>
    <v-card
      class="mx-auto"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="headline mb-1 text-center">Entidad valorable #1</v-list-item-title>
          <v-list-item-title class="headline mb-1">Puntuacion media:</v-list-item-title>
        </v-list-item-content>

        <v-list-item-avatar
          tile
          size="80"
          color="grey"
        ></v-list-item-avatar>
        <v-card-actions>
            <v-btn dark color="warning" text>EDITAR</v-btn>
          </v-card-actions>
      </v-list-item>

    </v-card>
    <v-row>
      <v-col cols="6">
        <v-card
          class="mx-auto"
          outlined
        >
          <v-list-item three-line>
            <v-list-item-content>
              <div class="overline mb-4">PUNTUACION MEDIA:</div>
              <v-list-item-title class="headline mb-1">Objeto valorable #1</v-list-item-title>
              <v-list-item-subtitle>Pequeño estracto</v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-avatar
              tile
              size="80"
              color="grey"
            ></v-list-item-avatar>
          </v-list-item>

          <v-card-actions>
            <v-btn text>Boton1</v-btn>
            <v-btn text>Boton2</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="6">
        <v-card
          class="mx-auto"
          outlined
        >
          <v-list-item three-line>
            <v-list-item-content>
              <div class="overline mb-4">PUNTUACION MEDIA:</div>
              <v-list-item-title class="headline mb-1">Objeto valorable #1</v-list-item-title>
              <v-list-item-subtitle>Pequeño estracto</v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-avatar
              tile
              size="80"
              color="grey"
            ></v-list-item-avatar>
          </v-list-item>

          <v-card-actions>
            <v-btn text>Boton1</v-btn>
            <v-btn text>Boton2</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="6">
        <v-card
          class="mx-auto"
          outlined
        >
          <v-list-item three-line>
            <v-list-item-content>
              <div class="overline mb-4">PUNTUACION MEDIA:</div>
              <v-list-item-title class="headline mb-1">Objeto valorable #1</v-list-item-title>
              <v-list-item-subtitle>Pequeño estracto</v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-avatar
              tile
              size="80"
              color="grey"
            ></v-list-item-avatar>
          </v-list-item>

          <v-card-actions>
            <v-btn text>Boton1</v-btn>
            <v-btn text>Boton2</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="6">
        <v-card
          class="mx-auto"
          outlined
        >
          <v-list-item three-line>
            <v-list-item-content>
              <div class="overline mb-4">PUNTUACION MEDIA:</div>
              <v-list-item-title class="headline mb-1">Objeto valorable #1</v-list-item-title>
              <v-list-item-subtitle>Pequeño estracto</v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-avatar
              tile
              size="80"
              color="grey"
            ></v-list-item-avatar>
          </v-list-item>

          <v-card-actions>
            <v-btn text>Boton1</v-btn>
            <v-btn text>Boton2</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="500">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">Añadir</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">Añadir nuevo Objeto valorable</v-card-title>
          <v-card-text>
            <v-form>
              <v-text-field
                id="nuevo_objeto_titulo"
                label="Titulo..."
                name="nuevo_objeto_titulo"
                type="text"
              ></v-text-field>
              <v-text-field
                id="nuevo_objeto_imagen"
                label="URL de imagen (opcional)"
                name="nuevo_objeto_imagen"
                type="text"
              ></v-text-field>
              <v-text-field
                id="nuevo_objeto_info"
                label="Información extra (opcional)"
                name="nuevo_objeto_info"
                type="text"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="dialog = false">Cancelar</v-btn>
            <v-btn color="green darken-1" text @click="dialog = false">Añadir</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    data () {
      return {
        dialog: false,
      }
    },
  }
</script>