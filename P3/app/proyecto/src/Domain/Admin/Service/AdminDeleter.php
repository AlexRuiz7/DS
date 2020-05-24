<?php

namespace App\Domain\Admin\Service;

use App\Domain\Admin\Data\AdminData;
use App\Domain\Admin\Repository\AdminRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class AdminDeleter {
    /**
     * @var AdminRepository
     */
    private $repository;

    /**
     * El constructor.
     *
     * @param AdminRepository $repository El repositorio
     */
    public function __construct(AdminRepository $repository) {
        $this->repository = $repository;
    }

   /**
    * Elimina el Admin
    *
    * @param AdminData $Admin
    * @return integer
    */
    public function eliminarAdmin(AdminData $Admin): int {
        // Validation
        if (empty($Admin->entidadesId)) {
            throw new InvalidArgumentException('Es necesario un ID de entidad');
        }
        if (empty($Admin->usuariosNombre)) {
            throw new InvalidArgumentException('Es necesario un nombre de usuario');
        }
        // Obtener datos de Admin
        $resultado = $this->repository->deleteAdmin($Admin);

        return $resultado;
    }
}

?>