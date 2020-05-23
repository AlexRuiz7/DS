<?php

namespace App\Domain\Valorable\Service;

use App\Domain\Valorable\Data\ValorableData;
use App\Domain\Valorable\Repository\ValorableRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValorableGetter {
    /**
     * @var ValorableRepository
     */
    private $repository;

    /**
     * El constructor.
     *
     * @param ValorableRepository $repository El repositorio
     */
    public function __construct(ValorableRepository $repository) {
        $this->repository = $repository;
    }

    /**
     * Consultar información de la Valorable.
     *
     * @param ValorableData $Valorable The Valorable data
     *
     * @throws InvalidArgumentException
     *
     * @return array Los datos de Valorable
     */
    public function getValorable(ValorableData $Valorable): array {
        // Validation
        if (empty($Valorable->entidadesId)) {
            throw new InvalidArgumentException('Es necesario un Id de la entidad');
        }
        if (empty($Valorable->id)) {
            throw new InvalidArgumentException('Es necesario un id de valorable');
        }

        // Obtener datos de Valorable
        $Valorable = $this->repository->selectValorable($Valorable);

        // Logging here: Valorable created successfully

        return $Valorable;
    }
}

?>