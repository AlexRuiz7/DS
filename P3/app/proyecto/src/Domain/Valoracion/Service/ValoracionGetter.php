<?php

namespace App\Domain\Valoracion\Service;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Repository\ValoracionRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class ValoracionGetter {
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
     * Consultar información de la Valoracion.
     *
     * @param ValoracionData $Valoracion The Valoracion data
     *
     * @throws InvalidArgumentException
     *
     * @return array Los datos de Valoracion
     */
    public function getValoracion(ValoracionData $Valoracion): array {
        // Validation
        if (empty($Valoracion->valorablesEntidadesId)) {
            throw new InvalidArgumentException('Es necesario un Id de la entidad del valorable');
        }
        if (empty($Valoracion->valorablesId)) {
            throw new InvalidArgumentException('Es necesario un id de Valorable');
        }
        if (empty($Valoracion->usuariosNombre)) {
            throw new InvalidArgumentException('Es necesario un nombre de usuario');
        }
        // Obtener datos de Valoracion
        $Valoracion = $this->repository->selectValoracion($Valoracion);

        // Logging here: Valoracion created successfully

        return $Valoracion;
    }
}

?>