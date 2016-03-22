package org.elixir_lang.psi.stub.type;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import org.elixir_lang.psi.ElixirMatchedDotCall;
import org.elixir_lang.psi.impl.ElixirMatchedDotCallImpl;
import org.elixir_lang.psi.stub.type.call.Stub;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MatchedDotCall extends Stub<org.elixir_lang.psi.stub.MatchedDotCall, ElixirMatchedDotCall> {
    /*
     * Constructors
     */

    public MatchedDotCall(@NotNull String debugName) {
        super(debugName);
    }

    /*
     * Instance Methods
     */

    @Override
    public ElixirMatchedDotCall createPsi(@NotNull org.elixir_lang.psi.stub.MatchedDotCall stub) {
        return new ElixirMatchedDotCallImpl(stub, this);
    }

    @Override
    public org.elixir_lang.psi.stub.MatchedDotCall createStub(@NotNull ElixirMatchedDotCall psi, StubElement parentStub) {
        return new org.elixir_lang.psi.stub.MatchedDotCall(
                parentStub,
                this,
                psi.resolvedModuleName(),
                psi.resolvedFunctionName(),
                psi.resolvedFinalArity(),
                psi.hasDoBlockOrKeyword(),
                psi.getName()
        );
    }

    @NotNull
    @Override
    public org.elixir_lang.psi.stub.MatchedDotCall deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new org.elixir_lang.psi.stub.MatchedDotCall(
                parentStub,
                this,
                dataStream.readName(),
                dataStream.readName(),
                dataStream.readInt(),
                dataStream.readBoolean(),
                dataStream.readName()
        );
    }
}