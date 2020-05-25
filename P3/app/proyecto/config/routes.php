<?php

use Slim\App;

#Para el CORS
use Slim\Exception\HttpNotFoundException;

return function (App $app) {
    $app->setBasePath('/api');
    

    $app->add(function ($request, $handler) {
        $response = $handler->handle($request);
        return $response
            ->withHeader('Access-Control-Allow-Origin', 'localhost:8081')
            ->withHeader('Access-Control-Allow-Headers', 'X-Requested-With, Content-Type, Accept, Origin, Authorization')
            ->withHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
    });
    
    $app->get('/', \App\Action\HomeAction::class);
    

    /**
     * Rutas de usuario
     */
    $app->get('/usuarios/{id}', \App\Action\UsuarioGetAction::class);
    $app->post('/usuarios',     \App\Action\UsuarioCreateAction::class);
    $app->put('/usuarios',      \App\Action\UsuarioModifyAction::class);
    $app->delete('/usuarios',   \App\Action\UsuarioDeleteAction::class);

    /**
     * Rutas de entidades
     */
    $app->get('/entidades/{id}', \App\Action\EntidadGetAction::class);
    $app->post('/entidades',     \App\Action\EntidadCreateAction::class);
    $app->put('/entidades',      \App\Action\EntidadModifyAction::class);
    $app->delete('/entidades',   \App\Action\EntidadDeleteAction::class);

    /**
     * Rutas de admins
     */
    $app->get('/admins/{entidadesId}', \App\Action\AdminGetAction::class); //Pasamos id
    $app->post('/admins',     \App\Action\AdminCreateAction::class);
    $app->put('/admins',      \App\Action\AdminModifyAction::class);
    $app->delete('/admins',   \App\Action\AdminDeleteAction::class);

    /**
     * Rutas de superadmins
     */
    $app->get('/superadmins/{entidadesId}', \App\Action\SuperAdminGetAction::class); //Pasamos id
    $app->post('/superadmins',     \App\Action\SuperAdminCreateAction::class);
    $app->put('/superadmins',      \App\Action\SuperAdminModifyAction::class);
    $app->delete('/superadmins',   \App\Action\SuperAdminDeleteAction::class);

    /**
     * Rutas de valorables
     */
    $app->get('/valorables/{entidadesId}', \App\Action\ValorableGetAction::class); //Pasamos id
    $app->post('/valorables',     \App\Action\ValorableCreateAction::class);
    $app->put('/valorables',      \App\Action\ValorableModifyAction::class);
    $app->delete('/valorables',   \App\Action\ValorableDeleteAction::class);
    
    /**
     * Rutas de valoraciones
     */
    $app->get('/valoraciones/{valorablesEntidadesId}', \App\Action\ValoracionGetAction::class); //Pasamos id
    $app->post('/valoraciones',     \App\Action\ValoracionCreateAction::class);
    $app->put('/valoraciones',      \App\Action\ValoracionModifyAction::class);
    $app->delete('/valoraciones',   \App\Action\ValoracionDeleteAction::class);

    /**
     * Catch-all route to serve a 404 Not Found page if none of the routes match
     * NOTE: make sure this route is defined last
     */
    $app->map(['GET', 'POST', 'PUT', 'DELETE', 'PATCH'], '/{routes:.+}', function ($request, $response) {
        throw new HttpNotFoundException($request);
    });

};

?>