import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Folder from './folder';
import FolderDetail from './folder-detail';
import FolderUpdate from './folder-update';
import FolderDeleteDialog from './folder-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={FolderUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={FolderUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={FolderDetail} />
      <ErrorBoundaryRoute path={match.url} component={Folder} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={FolderDeleteDialog} />
  </>
);

export default Routes;
