<?php

namespace App\Domain\Valorable\Service;

use App\Domain\Valorable\Data\ValorableData;
use App\Domain\Valorable\Repository\ValorableRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValorableDeleter {
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
    * Elimina la Valorable
    *
    * @param ValorableData $Valorable
    * @return integer
    */
    public function eliminarValorable(ValorableData $Valorable): int {
        // Validation
        if (empty($Valorable->entidadesId)) {
            throw new InvalidArgumentException('Hace falta un id de la entidad');
        }
        if (empty($Valorable->id)){
            throw new InvalidArgumentException('Es necesario un Id');
        }
        // Obtener datos de Valorable
        $resultado = $this->repository->deleteValorable($Valorable);

        return $resultado;
    }
}

?>