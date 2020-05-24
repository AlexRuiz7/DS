<?php

namespace App\Domain\Admin\Service;

use App\Domain\Admin\Data\AdminData;
use App\Domain\Admin\Repository\AdminRepository;
use InvalidArgumentException;

/**
 * Servicio.
 */
final class AdminModifier {
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
    * Modifica la Admin
    *
    * @param AdminData $Admin
    * @return integer
    */
    public function modificarAdmin(AdminData $Admin): int {
        // Validation
        if (empty($Admin->entidadesId)) {
            throw new InvalidArgumentException('Hace falta un Id de entidad');
        }
        if (empty($Admin->usuariosNombre)) {
            throw new InvalidArgumentException('Hace falta un nombre de usuario');
        }
        // Obtener datos de Admin
        $resultado = $this->repository->updateAdmin($Admin);

        return $resultado;
    }
}

?>