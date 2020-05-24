<?php

namespace App\Domain\SuperAdmin\Service;

use App\Domain\SuperAdmin\Data\SuperAdminData;
use App\Domain\SuperAdmin\Repository\SuperAdminRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class SuperAdminCreator {
    /**
     * @var SuperAdminRepository
     */
    private $repository;

    /**
     * The constructor.
     *
     * @param SuperAdminRepository $repository The repository
     */
    public function __construct(SuperAdminRepository $repository) {
        $this->repository = $repository;
    }

    /**
     * Crea una nueva SuperAdmin.
     *
     * @param SuperAdminData $SuperAdmin The SuperAdmin data
     *
     * @throws InvalidArgumentException
     *
     * @return int The new SuperAdmin ID
     */
    public function crearSuperAdmin(SuperAdminData $SuperAdmin): int {
        // Validation
        if (empty($SuperAdmin->entidadesId)) {
            throw new InvalidArgumentException('Hace falta un Id de entidad');
        }
        if (empty($SuperAdmin->usuariosNombre)) {
            throw new InvalidArgumentException('Hace falta un nombre de usuario');
        }

        // Insert SuperAdmin
        $SuperAdminId = $this->repository->insertSuperAdmin($SuperAdmin);

        // Logging here: SuperAdmin created successfully

        return $SuperAdminId;
    }
}

?>