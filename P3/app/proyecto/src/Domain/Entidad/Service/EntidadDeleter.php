<?php

namespace App\Domain\Entidad\Service;

use App\Domain\Entidad\Data\EntidadData;
use App\Domain\Entidad\Repository\EntidadRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class EntidadDeleter {
    /**
     * @var EntidadRepository
     */
    private $repository;

    /**
     * El constructor.
     *
     * @param EntidadRepository $repository El repositorio
     */
    public function __construct(EntidadRepository $repository) {
        $this->repository = $repository;
    }

   /**
    * Elimina la Entidad
    *
    * @param EntidadData $Entidad
    * @return integer
    */
    public function eliminarEntidad(EntidadData $Entidad): int {
        // Validation
        if (empty($Entidad->id))
            throw new InvalidArgumentException('Es necesario un Id');
        if (empty($Entidad->titulo))
            throw new InvalidArgumentException('Es necesario un titulo');

        // Obtener datos de Entidad
        $resultado = $this->repository->deleteEntidad($Entidad);

        return $resultado;
    }
}

?>