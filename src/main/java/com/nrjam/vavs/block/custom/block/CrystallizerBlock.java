package com.nrjam.vavs.block.custom.block;

import com.nrjam.vavs.block.entity.BlockEntities;
import com.nrjam.vavs.block.entity.custom.CrystallizerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class CrystallizerBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

        public CrystallizerBlock(Properties properties) {
            super(properties);
        }

        @Override
        public BlockState mirror (BlockState pState, Mirror pMirror){
            return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
        }

        @Override
        protected void createBlockStateDefinition (StateDefinition.Builder <Block, BlockState > pBuilder){
            pBuilder.add(FACING);
        }

        @Override
        public RenderShape getRenderShape (BlockState pState){
            return RenderShape.MODEL;
        }

        @Override
        public void onRemove (BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving){
            if (pState.getBlock() != pNewState.getBlock()) {
                BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
                if (blockEntity instanceof CrystallizerEntity) {
                    ((CrystallizerEntity) blockEntity).drops();
                }
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }

        @Override
        public InteractionResult use (BlockState pState, Level pLevel, BlockPos pPos,
                                      Player pPlayer, InteractionHand pHand, BlockHitResult pHit){
            if (!pLevel.isClientSide()) {
                BlockEntity entity = pLevel.getBlockEntity(pPos);
                if (entity instanceof CrystallizerEntity) {
                    NetworkHooks.openGui(((ServerPlayer) pPlayer), (CrystallizerEntity) entity, pPos);
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity (BlockPos pPos, BlockState pState){
            return new CrystallizerEntity(pPos, pState);
        }

        @Nullable
        @Override
        public <T extends
        BlockEntity > BlockEntityTicker< T > getTicker(Level pLevel, BlockState pState, BlockEntityType< T > pBlockEntityType)
        {
            return createTickerHelper(pBlockEntityType, BlockEntities.CRYSTALLIZER.get(), CrystallizerEntity::tick);
        }
}
