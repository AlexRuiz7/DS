<?php

namespace App\Domain\Valoracion\Service;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Repository\ValoracionRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValoracionCreator {
    /**
     * @var ValoracionRepository
     */
    private $repository;

    /**
     * The constructor.
     *
     * @param ValoracionRepository $repository The repository
     */
    public function __construct(ValoracionRepository $repository) {
        $this->repository = $repository;
    }

    /**
     * Crea una nueva Valoracion.
     *
     * @param ValoracionData $Valoracion The Valoracion data
     *
     * @throws InvalidArgumentException
     *
     * @return int The new Valoracion ID
     */
    public function crearValoracion(ValoracionData $Valoracion): int {
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
        // Insert Valoracion
        $ValoracionId = $this->repository->insertValoracion($Valoracion);

        // Logging here: Valoracion created successfully

        return $ValoracionId;
    }
}

?>