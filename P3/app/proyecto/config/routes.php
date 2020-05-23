<?php

use Slim\App;

return function (App $app) {
    $app->get('/', \App\Action\HomeAction::class);

    /**
     * Rutas de usuario
     */
    $app->get('/usuarios/{id}', \App\Action\UsuarioGetAction::class);
    $app->post('/usuarios',     \App\Action\UsuarioCreateAction::class);
    $app->put('/usuarios',      \App\Action\UsuarioModifyAction::class);
    $app->delete('/usuarios',   \App\Action\UsuarioDeleteAction::class);

    // $app->get('/usuarios', function ($request, $response, $params) {
    //     $response->getBody()->write((string)json_encode($request->getParsedBody()));

    //     return $response;
    // });

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
};

?>