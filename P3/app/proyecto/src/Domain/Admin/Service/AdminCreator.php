<?php

namespace App\Domain\Admin\Service;

use App\Domain\Admin\Data\AdminData;
use App\Domain\Admin\Repository\AdminRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class AdminCreator {
    /**
     * @var AdminRepository
     */
    private $repository;

    /**
     * The constructor.
     *
     * @param AdminRepository $repository The repository
     */
    public function __construct(AdminRepository $repository) {
        $this->repository = $repository;
    }

    /**
     * Crea una nueva Admin.
     *
     * @param AdminData $Admin The Admin data
     *
     * @throws InvalidArgumentException
     *
     * @return int The new Admin ID
     */
    public function crearAdmin(AdminData $Admin): int {
        // Validation
        if (empty($Admin->entidadesId)) {
            throw new InvalidArgumentException('Hace falta un Id de entidad');
        }
        if (empty($Admin->usuariosNombre)) {
            throw new InvalidArgumentException('Hace falta un nombre de usuario');
        }

        // Insert Admin
        $AdminId = $this->repository->insertAdmin($Admin);

        // Logging here: Admin created successfully

        return $AdminId;
    }
}

?>