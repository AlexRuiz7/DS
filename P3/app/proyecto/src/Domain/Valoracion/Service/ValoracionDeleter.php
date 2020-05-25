<?php

namespace App\Domain\Valoracion\Service;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Repository\ValoracionRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValoracionDeleter {
    /**
     * @var ValoracionRepository
     */
    private $repository;

    /**
     * El constructor.
     *
     * @param ValoracionRepository $repository El repositorio
     */
    public function __construct(ValoracionRepository $repository) {
        $this->repository = $repository;
    }

   /**
    * Elimina la Valoracion
    *
    * @param ValoracionData $Valoracion
    * @return integer
    */
    public function eliminarValoracion(ValoracionData $Valoracion): int {
        // Validation
        if (empty($Valoracion->valorablesEntidadesId)) {
            throw new InvalidArgumentException('Es necesario un Id de la entidad del Valoracion');
        }
        if (empty($Valoracion->valorablesId)) {
            throw new InvalidArgumentException('Es necesario un id de Valoracion');
        }
        if (empty($Valoracion->usuariosNombre)) {
            throw new InvalidArgumentException('Es necesario un nombre de usuario');
        }
        // Obtener datos de Valoracion
        $resultado = $this->repository->deleteValoracion($Valoracion);

        return $resultado;
    }
}

?>