<?php

namespace App\Domain\SuperAdmin\Service;

use App\Domain\SuperAdmin\Data\SuperAdminData;
use App\Domain\SuperAdmin\Repository\SuperAdminRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class SuperAdminModifier {
    /**
     * @var SuperAdminRepository
     */
    private $repository;

    /**
     * El constructor.
     *
     * @param SuperAdminRepository $repository El repositorio
     */
    public function __construct(SuperAdminRepository $repository) {
        $this->repository = $repository;
    }

   /**
    * Modifica la SuperAdmin
    *
    * @param SuperAdminData $SuperAdmin
    * @return integer
    */
    public function modificarSuperAdmin(SuperAdminData $SuperAdmin): int {
        // Validation
        if (empty($SuperAdmin->entidadesId)) {
            throw new InvalidArgumentException('Hace falta un Id de entidad');
        }
        if (empty($SuperAdmin->usuariosNombre)) {
            throw new InvalidArgumentException('Hace falta un nombre de usuario');
        }
        // Obtener datos de SuperAdmin
        $resultado = $this->repository->updateSuperAdmin($SuperAdmin);

        return $resultado;
    }
}

?>