<?php

namespace App\Domain\Valoracion\Service;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Repository\ValoracionRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValoracionModifier {
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
    * Modifica la Valoracion
    *
    * @param ValoracionData $Valoracion
    * @return integer
    */
    public function modificarValoracion(ValoracionData $Valoracion): int {
        // Validation
        if (empty($Valoracion->valorablesEntidadesId)) {
            throw new InvalidArgumentException('Hace falta un id de la entidad del valorable');
        }
        if (empty($Valoracion->valorablesId)) {
            throw new InvalidArgumentException('Hace falta un id del valorable');
        }
        if (empty($Valoracion->usuariosNombre)) {
            throw new InvalidArgumentException('Hace falta un nombre de usuario');
        }
        if (empty($Valoracion->puntuacion)) {
            throw new InvalidArgumentException('Hace falta una puntuacion');
        }
        if (empty($Valoracion->comentario)) {
            throw new InvalidArgumentException('Hace falta un comentario');
        }
        if (empty($Valoracion->fecha)) {
            throw new InvalidArgumentException('Hace falta una fecha');
        }
        // Obtener datos de Valoracion
        $resultado = $this->repository->updateValoracion($Valoracion);

        return $resultado;
    }
}

?>