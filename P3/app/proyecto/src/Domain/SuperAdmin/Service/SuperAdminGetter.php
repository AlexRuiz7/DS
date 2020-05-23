<?php

namespace App\Domain\SuperAdmin\Service;

use App\Domain\SuperAdmin\Data\SuperAdminData;
use App\Domain\SuperAdmin\Repository\SuperAdminRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class SuperAdminGetter {
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
     * Consultar información de la SuperAdmin.
     *
     * @param SuperAdminData $SuperAdmin The SuperAdmin data
     *
     * @throws InvalidArgumentException
     *
     * @return array Los datos de SuperAdmin
     */
    public function getSuperAdmin(SuperAdminData $SuperAdmin): array {
        // Validation
        if (empty($SuperAdmin->entidadesId)) {
            throw new InvalidArgumentException('Es necesario un ID de entidad');
        }
        if (empty($SuperAdmin->usuariosNombre)) {
            throw new InvalidArgumentException('Es necesario un nombre de usuario');
        }
        // Obtener datos de SuperAdmin
        $SuperAdmin = $this->repository->selectSuperAdmin($SuperAdmin);

        // Logging here: SuperAdmin created successfully

        return $SuperAdmin;
    }
}

?>