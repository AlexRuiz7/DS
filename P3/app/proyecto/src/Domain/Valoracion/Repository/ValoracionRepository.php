<?php

namespace App\Domain\Valoracion\Repository;

use App\Domain\Valoracion\Data\ValoracionData;
use PDO;

/**
 * Repository.
 */
class ValoracionRepository {
    /**
     * @var PDO The database connection
     */
    private $connection;

    /**
     * Constructor.
     *
     * @param PDO $connection The database connection
     */
    public function __construct(PDO $connection) {
        $this->connection = $connection;
    }

    /**
     * Consulta la información de Valoracion
     *
     * @param ValoracionData $Valoracion
     * @return array datos de la Valoracion
     */
    public function selectValoracion(ValoracionData $Valoracion) : array {
        $fila = [
            'valorablesEntidadesId' => $Valoracion->valorablesEntidadesId,
            'valorablesId' => $Valoracion->valorablesId,
            'usuariosNombre' => $Valoracion->usuariosNombre,
        ];
        $sql = "SELECT * FROM Valoraciones WHERE ValorablesEntidadesID=:valorablesEntidadesId AND ValorablesID=:valorablesId AND Usuariosnombre=:usuariosNombre";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $datos = $stmt->fetchAll();

        return $datos;
    }

    /**
     * Undocumented function
     *
     * @param ValoracionData $Valoracion
     * @return array
     */
    public function selectValoraciones(ValoracionData $Valoracion) : array {
        $fila = [
            'valorablesEntidadesId' => $Valoracion->valorablesEntidadesId,
            'valorablesId' => $Valoracion->valorablesId,
        ];
        $sql = "SELECT * FROM Valoraciones WHERE ValorablesEntidadesID=:valorablesEntidadesId AND ValorablesID=:valorablesId";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $datos = $stmt->fetchAll();

        return $datos;
    }

    /**
     * Inserta Valoracion.
     *
     * @param ValoracionCreateData $Valoracion la Valoracion
     *
     * @return int The new ID
     */
    public function insertValoracion(ValoracionData $Valoracion): int {

        $fila = [
            'valorablesEntidadesId' => $Valoracion->valorablesEntidadesId,
            'valorablesId' => $Valoracion->valorablesId,
            'usuariosNombre' => $Valoracion->usuariosNombre,
            'puntuacion' => $Valoracion->puntuacion,
            'comentario' => $Valoracion->comentario,
            'fecha' => $Valoracion->fecha
        ];

        $sql = "INSERT IGNORE INTO Valoraciones (ValorablesEntidadesId, ValorablesID, UsuariosNombre, puntuacion, comentario, fecha) VALUES (:valorablesEntidadesId, :valorablesId, :usuariosNombre, :puntuacion, :comentario, :fecha)";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $estado = $stmt->rowCount();

        return $estado;
    }

    /**
     * Elimina el Valoracion
     *
     * @param ValoracionData $Valoracion
     * @return int datos de la Valoracion
     */
    public function deleteValoracion(ValoracionData $Valoracion) : int {
        $fila = [
            'valorablesEntidadesId' => $Valoracion->valorablesEntidadesId,
            'valorablesId' => $Valoracion->valorablesId,
            'usuariosNombre' => $Valoracion->usuariosNombre
        ];
        $sql = "DELETE FROM Valoraciones WHERE ValorablesEntidadesID=:valorablesEntidadesId AND ValorablesID=:valorablesId AND Usuariosnombre=:usuariosNombre";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $estado = $stmt->rowCount();

        return $estado;
    }

    /**
     * Modifica el Valoracion
     *
     * @param ValoracionData $Valoracion
     * @return int estado de la actualizacion
     */
    public function updateValoracion(ValoracionData $Valoracion) : int {
        $fila = [
            'valorablesEntidadesId' => $Valoracion->valorablesEntidadesId,
            'valorablesId' => $Valoracion->valorablesId,
            'usuariosNombre' => $Valoracion->usuariosNombre,
            'puntuacion' => $Valoracion->puntuacion,
            'comentario' => $Valoracion->comentario,
            'fecha' => $Valoracion->fecha
        ];

        $sql = "UPDATE Valoraciones SET puntuacion=:puntuacion, comentario=:comentario, fecha=:fecha WHERE ValorablesEntidadesID=:valorablesEntidadesId AND ValorablesID=:valorablesId AND Usuariosnombre=:usuariosNombre";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $estado = $stmt->rowCount();

        return $estado;
    }
}

?>