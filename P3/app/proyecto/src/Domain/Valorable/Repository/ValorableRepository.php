<?php

namespace App\Domain\Valorable\Repository;

use App\Domain\Valorable\Data\ValorableData;
use PDO;

/**
 * Repository.
 */
class ValorableRepository {
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
     * Consulta la información de Valorable
     *
     * @param ValorableData $Valorable
     * @return array datos de la Valorable
     */
    public function selectValorable(ValorableData $Valorable) : array {
        $fila = [
            'entidadesId' => $Valorable->entidadesId,
            'id' => $Valorable->id,
        ];
        $sql = "SELECT * FROM Valorables WHERE EntidadesID=:entidadesId AND ID=:id";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $datos = $stmt->fetchAll();

        return $datos;
    }

    /**
     * Inserta Valorable.
     *
     * @param ValorableCreateData $Valorable la Valorable
     *
     * @return int The new ID
     */
    public function insertValorable(ValorableData $Valorable): int {

        $fila = [
            'entidadesId' => $Valorable->entidadesId,
            'titulo' => $Valorable->titulo,
            'descripcion' => $Valorable->descripcion,
            'imagen' => $Valorable->imagen
        ];

        $sql = "INSERT IGNORE INTO Valorables (EntidadesID, titulo, descripcion, imagen) VALUES (:entidadesId, :titulo, :descripcion, :imagen)";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $estado = $stmt->rowCount();

        return $estado;
    }

    /**
     * Elimina el Valorable
     *
     * @param ValorableData $Valorable
     * @return int datos de la Valorable
     */
    public function deleteValorable(ValorableData $Valorable) : int {
        $fila = [
            'entidadesId' => $Valorable->entidadesId,
            'id' => $Valorable->id,
        ];
        $sql = "DELETE FROM Valorables WHERE EntidadesID=:entidadesId AND ID=:id";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $estado = $stmt->rowCount();

        return $estado;
    }

    /**
     * Modifica el Valorable
     *
     * @param ValorableData $Valorable
     * @return int estado de la actualizacion
     */
    public function updateValorable(ValorableData $Valorable) : int {
        $fila = [
            'entidadesId' => $Valorable->entidadesId,
            'id' => $Valorable->id,
            'titulo' => $Valorable->titulo,
            'descripcion' => $Valorable->descripcion,
            'imagen' => $Valorable->imagen
        ];

        $sql = "UPDATE Valorables SET titulo=:titulo, descripcion=:descripcion, imagen=:imagen WHERE EntidadesID=:entidadesId AND ID=:id";
        $stmt = $this->connection->prepare($sql);
        $stmt->execute($fila);
        $estado = $stmt->rowCount();

        return $estado;
    }
}

?>