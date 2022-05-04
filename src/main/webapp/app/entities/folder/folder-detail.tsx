import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './folder.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const FolderDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const folderEntity = useAppSelector(state => state.folder.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="folderDetailsHeading">
          <Translate contentKey="tabApp.folder.detail.title">Folder</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{folderEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="tabApp.folder.name">Name</Translate>
            </span>
          </dt>
          <dd>{folderEntity.name}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="tabApp.folder.description">Description</Translate>
            </span>
          </dt>
          <dd>{folderEntity.description}</dd>
          <dt>
            <Translate contentKey="tabApp.folder.folder">Folder</Translate>
          </dt>
          <dd>{folderEntity.folder ? folderEntity.folder.id : ''}</dd>
          <dt>
            <Translate contentKey="tabApp.folder.user">User</Translate>
          </dt>
          <dd>{folderEntity.user ? folderEntity.user.id : ''}</dd>
          <dt>
            <Translate contentKey="tabApp.folder.image">Image</Translate>
          </dt>
          <dd>
            {folderEntity.images
              ? folderEntity.images.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {folderEntity.images && i === folderEntity.images.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/folder" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/folder/${folderEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default FolderDetail;
