import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, openFile, byteSize, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './image.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const ImageDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const imageEntity = useAppSelector(state => state.image.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="imageDetailsHeading">
          <Translate contentKey="tabApp.image.detail.title">Image</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{imageEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="tabApp.image.name">Name</Translate>
            </span>
          </dt>
          <dd>{imageEntity.name}</dd>
          <dt>
            <span id="image">
              <Translate contentKey="tabApp.image.image">Image</Translate>
            </span>
          </dt>
          <dd>
            {imageEntity.image ? (
              <div>
                {imageEntity.imageContentType ? (
                  <a onClick={openFile(imageEntity.imageContentType, imageEntity.image)}>
                    <img src={`data:${imageEntity.imageContentType};base64,${imageEntity.image}`} style={{ maxHeight: '30px' }} />
                  </a>
                ) : null}
                <span>
                  {imageEntity.imageContentType}, {byteSize(imageEntity.image)}
                </span>
              </div>
            ) : null}
          </dd>
          <dt>
            <span id="description">
              <Translate contentKey="tabApp.image.description">Description</Translate>
            </span>
          </dt>
          <dd>{imageEntity.description}</dd>
          <dt>
            <span id="imageSize">
              <Translate contentKey="tabApp.image.imageSize">Image Size</Translate>
            </span>
          </dt>
          <dd>{imageEntity.imageSize}</dd>
          <dt>
            <span id="format">
              <Translate contentKey="tabApp.image.format">Format</Translate>
            </span>
          </dt>
          <dd>{imageEntity.format}</dd>
          <dt>
            <span id="dateOfCreate">
              <Translate contentKey="tabApp.image.dateOfCreate">Date Of Create</Translate>
            </span>
          </dt>
          <dd>
            {imageEntity.dateOfCreate ? <TextFormat value={imageEntity.dateOfCreate} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <Translate contentKey="tabApp.image.user">User</Translate>
          </dt>
          <dd>{imageEntity.user ? imageEntity.user.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/image" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/image/${imageEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default ImageDetail;
