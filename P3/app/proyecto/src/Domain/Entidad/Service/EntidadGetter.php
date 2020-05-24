<?php

namespace App\Domain\Entidad\Service;

use App\Domain\Entidad\Data\EntidadData;
use App\Domain\Entidad\Repository\EntidadRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class EntidadGetter {
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
     * Consultar información de la Entidad.
     *
     * @param EntidadData $Entidad The Entidad data
     *
     * @throws InvalidArgumentException
     *
     * @return array Los datos de Entidad
     */
    public function getEntidad(EntidadData $Entidad): array {
        // Validation
        if (empty($Entidad->id)) {
            throw new InvalidArgumentException('Es necesario un titulo');
        }

        // Obtener datos de Entidad
        $Entidad = $this->repository->selectEntidad($Entidad);

        // Logging here: Entidad created successfully

        return $Entidad;
    }
}

?>