behemothModule.factory('Book', function ($resource) {
    return $resource(
        CTX + '/book/:id',
        { id: '@BookId' },
        { update: { method: 'PUT' } }
    );
});