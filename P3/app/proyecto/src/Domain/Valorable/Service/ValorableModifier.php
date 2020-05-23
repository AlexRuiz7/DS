<?php

namespace App\Domain\Valorable\Service;

use App\Domain\Valorable\Data\ValorableData;
use App\Domain\Valorable\Repository\ValorableRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValorableModifier {
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
    * Modifica la Valorable
    *
    * @param ValorableData $Valorable
    * @return integer
    */
    public function modificarValorable(ValorableData $Valorable): int {
        // Validation
        if (empty($Valorable->entidadesId)) {
            throw new InvalidArgumentException('Hace falta un id de la entidad');
        }
        if (empty($Valorable->id)){
            throw new InvalidArgumentException('Es necesario un Id');
        }
        if (empty($Valorable->titulo)) {
            throw new InvalidArgumentException('Hace falta un titulo');
        }
        if (empty($Valorable->descripcion)) {
            throw new InvalidArgumentException('Hace falta una descripcion');
        }
        if (empty($Valorable->imagen)) {
            throw new InvalidArgumentException('Hace falta una imagen');
        }
        // Obtener datos de Valorable
        $resultado = $this->repository->updateValorable($Valorable);

        return $resultado;
    }
}

?>